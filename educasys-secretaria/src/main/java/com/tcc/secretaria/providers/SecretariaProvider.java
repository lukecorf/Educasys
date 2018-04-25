package com.tcc.secretaria.providers;

import com.google.gson.Gson;
import com.tcc.secretaria.DTO.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SecretariaProvider {
    Gson gson = new Gson();

    @GetMapping(value = "/getDisciplinas")
    public @ResponseBody String getDisciplinas(){
        ArrayList<DisciplinaListDTO> disciplinas = new ArrayList<DisciplinaListDTO>();

        disciplinas.add(new DisciplinaListDTO(1L,"Web Avançado","Bruno Ferreira",60,"23/12"));
        disciplinas.add(new DisciplinaListDTO(2L,"Redes","Everthon Valadão",60,"11/11"));
        disciplinas.add(new DisciplinaListDTO(3L,"Banco de Dados","Patricia Proença",30,"10/12"));
        disciplinas.add(new DisciplinaListDTO(4L,"Mobile","Diego Mello",30,"13/10"));

        return gson.toJson(disciplinas);
    }

    @GetMapping(value = "/getAlunos")
    public @ResponseBody String getAlunos(){
        ArrayList<AlunoListDTO> list = new ArrayList<AlunoListDTO>();

        list.add(new AlunoListDTO(1L,"Lucas Alves","10/12/1995","3799998888"));
        list.add(new AlunoListDTO(2L,"Rafaela Bitencourt","10/12/1995","3799998888"));
        list.add(new AlunoListDTO(3L,"João Paulo","10/12/1995","3799998888"));
        list.add(new AlunoListDTO(4L,"Rodrigo Silva","10/12/1995","3799998888"));

        return gson.toJson(list);
    }

    @GetMapping(value = "/getProfessores")
    public @ResponseBody String getProfessores(){
        ArrayList<ProfessorListDTO> list = new ArrayList<ProfessorListDTO>();

        list.add(new ProfessorListDTO(1L,"Lucas Alves","10/12/1995","3799998888"));
        list.add(new ProfessorListDTO(2L,"Rafaela Bitencourt","10/12/1995","3799998888"));
        list.add(new ProfessorListDTO(3L,"João Paulo","10/12/1995","3799998888"));
        list.add(new ProfessorListDTO(4L,"Rodrigo Silva","10/12/1995","3799998888"));

        return gson.toJson(list);
    }

    @GetMapping("/getDisciplinaById/{id}")
    public @ResponseBody String getDisciplinaById(@PathVariable Long id) {
        System.out.println("ID: "+id);

        ArrayList<AlunoListDTO> list = new ArrayList<AlunoListDTO>();

        list.add(new AlunoListDTO(1L,"Lucas Alves","10/12/1995","3799998888"));
        list.add(new AlunoListDTO(2L,"Rafaela Bitencourt","10/12/1995","3799998888"));
        list.add(new AlunoListDTO(3L,"João Paulo","10/12/1995","3799998888"));
        list.add(new AlunoListDTO(4L,"Rodrigo Silva","10/12/1995","3799998888"));

        DisciplinaDTO disciplina = new DisciplinaDTO(1l,"Web Avançado",60,"Abrange as mais novas tecnologias de desenvolvimento web","Bruno Ferreira",list);

        return gson.toJson(disciplina);

    }

    @GetMapping("/getAlunoById/{id}")
    public @ResponseBody String getAlunoById(@PathVariable Long id) {
        System.out.println("ID: "+id);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        try {
            date = sdf.parse("27/07/2006");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        AlunoDTO aluno = new AlunoDTO(1L,"Lucas Alves","3399999999","luke@email.com","Rafael Jose","Edilamar Maria","Rua Dona Hortencia 158","123",date);

        return gson.toJson(aluno);

    }

    @GetMapping("/getProfessorById/{id}")
    public @ResponseBody String getProfessorById(@PathVariable Long id) {
        System.out.println("ID: "+id);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        try {
            date = sdf.parse("27/07/2008");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ProfessorDTO professor = new ProfessorDTO(1L,"Lucas Alves","3399999999","luke@email.com","111111111111","mg11111111","Rua Dona Hortencia 158","123",date);

        return gson.toJson(professor);

    }
}