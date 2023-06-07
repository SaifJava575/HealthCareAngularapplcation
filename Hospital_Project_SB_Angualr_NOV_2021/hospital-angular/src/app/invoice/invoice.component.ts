import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bill } from '../bill/Bill';
import { Department } from '../department/Department';
import { Doctor } from '../doctor/Doctor';
import { Insurance } from '../insurance/Insurance';
import { Patient } from '../patient/Patient';
import { BillService } from '../service/bill/bill.service';
import { MedicosService } from '../service/medicos/medicos.service';
import { TokenStorageService } from '../service/token-storage.service';
import { Specialization } from '../specialization/Specialization';
import { Test } from '../test/Test';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css'],
})
export class InvoiceComponent implements OnInit {
  id;
  gtotal;
  bill: Bill = new Bill();
  doc: Doctor = new Doctor();
  pat: Patient = new Patient();
  ins: Insurance = new Insurance();
  test: Test = new Test();
  dept: Department = new Department();
  spec: Specialization = new Specialization();

  medList: [];
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private ts: TokenStorageService,
    private bs: BillService,
    private ms: MedicosService
  ) {}

  ngOnInit(): void {
    if (this.ts.getToken()) {
      if (this.route.snapshot.params['id'] > 0) {
        this.id = this.route.snapshot.params['id'];
        this.getDetails();
      }
    } else {
      this.router.navigate(['login']);
    }
  }

  getDetails() {
    this.bs.getBillById(this.id).subscribe((data) => {
      this.bill = data;
      this.ins = this.bill.insurance;
      this.pat = this.ins.patient;
      this.doc = this.pat.doc;
      this.test = this.pat.test;
      this.dept = this.doc.department;
      this.spec = this.doc.specialization;
      this.getMedList();
      this.getTotal();
    });
  }

  getTotal() {
    this.ms.getTotal(this.pat.pid).subscribe(
      (total) => {
        this.gtotal = total;
      },
      (error) => console.log(error)
    );
  }

  getMedList() {
    this.ms.getMedicosByPatId(this.pat.pid).subscribe(
      (list) => {
        this.medList = list;
      },
      (error) => console.log(error)
    );
  }

  goBack() {
    this.router.navigate(['billList']);
  }

  goHome() {
    this.router.navigate(['home']);
  }

  print() {
    let printContents = document.getElementById('pdf').innerHTML;
    let originalContents = document.body.innerHTML;
    document.body.innerHTML = printContents;
    window.print();
    document.body.innerHTML = originalContents;
  }
}
