import {BaseDTO} from "../base/base.dto";

/**
 * Representa um token de autenticação do usuario.
 */
export class TaskDTO extends BaseDTO {

  title: string = null;
  taskStatus: string = null;
  dateStart: Date = null;
  dateUpdate: Date = null;
  dateRemove: Date = null;
  dateEnd: Date = null;
}