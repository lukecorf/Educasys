import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Professor} from "../secretary/professor-s/professor-s.model";
import {Disciplina} from "../student/home-a/models/materia.model";
import {Arquivo, Atividade} from "./teacher.module";
import {AlunoList} from "../secretary/aluno-s/aluno-s.model";

@Injectable()
export class TeacherService{

  private url = 'http://localhost:8090/getProfessorByCode';
  private urlD = 'http://localhost:8090/getDisciplinaById';
  private urlMateria = 'http://localhost:8090/getDisciplinas';
  private urlSAtividade= 'http://localhost:8090/saveAtividade';
  private urlSArquivo= 'http://localhost:8090/saveArquivo';
  private urlGAtividades = 'http://localhost:8090/getAtividades';
  private urlGArquivos= 'http://localhost:8090/getArquivos';
  private urlDArquivo= 'http://localhost:8090/deleteArquivo';
  private urlDAtividade= 'http://localhost:8090/deleteAtividade';
  private urlGAlunos= 'http://localhost:8090/getAlunosByDisciplina';

  constructor(private  http: HttpClient){}

  getProfessorByCode(id: string):Observable<Professor>{
    return this.http.get<Professor>(this.url+'/'+id);
  }

  getDisciplinaById(id: number):Observable<Disciplina>{
    return this.http.get<Disciplina>(this.urlD+"/"+id);
  }

  getDisciplinas(id: number):Observable<Disciplina[]>{
    return this.http.get<Disciplina[]>(this.urlMateria+'/'+id);
  }

  setAtividade(a:Atividade):Observable<Atividade>{
    return this.http.post<Atividade>(this.urlSAtividade,a);
  }

  setArquivo(a:Arquivo):Observable<Arquivo>{
    return this.http.post<Arquivo>(this.urlSArquivo,a);
  }

  getAtividadesByIdDisciplina(id: number):Observable<Atividade[]>{
    return this.http.get<Atividade[]>(this.urlGAtividades+"/"+id);
  }

  getArquivosByIdDisciplina(id: number):Observable<Arquivo[]>{
    return this.http.get<Arquivo[]>(this.urlGArquivos+"/"+id);
  }

  getAlunosByIdDisciplina(id: number):Observable<AlunoList[]>{
    return this.http.get<AlunoList[]>(this.urlGAlunos+"/"+id);
  }

  deleteFileById(id: number): Observable<any>{
    return this.http.delete(this.urlDArquivo+'/'+id);
  }

  deleteAtividadeById(id: number): Observable<any>{
    return this.http.delete(this.urlDAtividade+'/'+id);
  }



}