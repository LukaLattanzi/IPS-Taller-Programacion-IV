import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from '../services/api.service'; // Asegúrate de que la ruta sea correcta

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
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
    this.apiService.getCategories().subscribe({
      next: (data) => {
        console.log('Categorías cargadas:', data);
        this.categories = data || []; // Asegúrate de que sea una lista
      },
      error: (error) => {
        console.error('Error al cargar categorías:', error);
        this.categories = []; // Inicializa como lista vacía en caso de error
      }
    });
  }
  
  loadProducts(): void {
    this.apiService.getProducts().subscribe({
      next: (data) => {
        console.log('Productos cargados:', data);
        this.products = data || []; // Asegúrate de que sea una lista
      },
      error: (error) => {
        console.error('Error al cargar productos:', error);
        this.products = []; // Inicializa como lista vacía en caso de error
      }
    });
  }
}