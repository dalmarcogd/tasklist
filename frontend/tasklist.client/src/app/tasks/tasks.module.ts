import { SharedModule } from './../shared/shared.module';
import { TasksService } from './tasks.service';
/**
 * Module das tasks
 */
import { CommonModule } from '@angular/common';
import { routing } from './tasks.routing';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { TasksComponent } from './tasks.component';
import { Ng2SmartTableModule } from 'ng2-smart-table';

@NgModule({
  imports: [
    routing,
    Ng2SmartTableModule,
    SharedModule
  ],
  declarations: [
    TasksComponent 
  ],
  exports: [
    TasksComponent,
    Ng2SmartTableModule
  ],
  bootstrap: [
    TasksComponent
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],
  providers: [
    
  ]
})
export class TasksModule { }
