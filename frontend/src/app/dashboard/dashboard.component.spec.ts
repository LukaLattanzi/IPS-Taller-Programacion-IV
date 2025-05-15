import { Component, OnInit } from '@angular/core';
import { ApiService } from '../services/api.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  categories: any[] = [];
  products: any[] = [];

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.loadCategories();
    this.loadProducts();
  }

  loadCategories(): void {
    this.apiService.getCategories().subscribe((data) => {
      console.log("Productos Cargados:", data)
      this.categories = data;
    });
  }

  loadProducts(): void {
    this.apiService.getProducts().subscribe((data) => {
      console.log("Categorias Cargadas:", data)
      this.products = data;
    });
  }
}