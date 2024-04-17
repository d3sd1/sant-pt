import {Component, OnDestroy, OnInit} from '@angular/core';
import {ApiService} from './api.service';
import {FormBuilder, FormGroup} from '@angular/forms';
import {CalculationResponseDto} from './dto/CalculationResponseDto';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy {
  formData: FormGroup;
  calcsInfo: CalculationResponseDto = new CalculationResponseDto();
  submitting = false;

  constructor(public apiService: ApiService, private formBuilder: FormBuilder) {

    this.formData = this.formBuilder.group({
      x: '',
      y: '',
      n: ''
    });
  }

  submit() {
    const [x, y, n] = [this.formData.get("x")?.getRawValue(), this.formData.get("y")?.getRawValue(), this.formData.get("n")?.getRawValue()];
    this.submitting = true;
    const sub = this.apiService.makeApiCall(x, y, n).subscribe((res) => {
      this.submitting = false;
      this.calcsInfo = res;
      sub.unsubscribe();
    }, (e) => {
      console.log(e);
      this.submitting = false;
    })
  }

  ngOnInit() {
  }

  ngOnDestroy() {
    // aqui lo sutyo es un subject que automaticamente unsubscriba todas las suscripciones
  }
}
