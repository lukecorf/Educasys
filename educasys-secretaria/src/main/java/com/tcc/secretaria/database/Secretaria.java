package com.tcc.secretaria.database;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "TBL_SECRETARIA")
public class Secretaria {

    @Id
    @Column( name  ="ID_SECRETARIA")
    @NotNull
    long codigo;

    @NotNull
    @Column( name = "ST_NOME_SECRETARIA")
    @Size(max = 100)
    String secretaria;

    @NotNull
    @Column( name = "ST_CODE")
    @Size(max = 11)
    String code;



    public Secretaria(@NotNull long codigo, @NotNull @Size(max = 100) String secretaria, @NotNull @Size(max = 11) String code) {
        this.codigo = codigo;
        this.secretaria = secretaria;
        this.code = code;
    }

    public Secretaria(){

    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(String secretaria) {
        this.secretaria = secretaria;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
