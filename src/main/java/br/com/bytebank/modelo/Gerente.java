package br.com.bytebank.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GERENTE")
@Data
@SuperBuilder
@Generated
@AllArgsConstructor
public class Gerente extends Funcionario implements Autenticavel, Serializable {

    @Id
    @GeneratedValue
    @Column(name = "OID_GERENTE")
    private Long id;

    @Column(name = "SENHA", length = 20, nullable = false)
    private String senha;

    @Override
    public Boolean autentica(String senha) {
        return this.senha.equals(senha);
    }

    @Override
    public int compareTo(Funcionario funcionario) {
        if (this.getSalario().compareTo(funcionario.getSalario()) < 0) {
            return 1;
        } else if (this.getSalario().compareTo(funcionario.getSalario()) > 0) {
            return -1;
        }
        return 0;
    }
}
