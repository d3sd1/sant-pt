import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CalculationResponseDto} from './dto/CalculationResponseDto';
import {environment} from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private httpClient: HttpClient) {
  }

  public makeApiCall(x: number, y: number, n: number): Observable<CalculationResponseDto> {
    if (!x || !y || !n) {
      alert("Introduce parámetros");
      return new Observable<CalculationResponseDto>();
    }
    return this.httpClient.get<CalculationResponseDto>(`${environment.apiUrl}/required_remainder?x=${x}&y=${y}&n=${n}`);
  }
}
