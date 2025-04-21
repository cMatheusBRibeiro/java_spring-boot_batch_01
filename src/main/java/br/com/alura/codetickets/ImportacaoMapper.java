package br.com.alura.codetickets;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ImportacaoMapper implements FieldSetMapper<Importacao> {

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public Importacao mapFieldSet(FieldSet fieldSet) throws BindException {
        var importacao = new Importacao();

        importacao.setCliente(fieldSet.readString("cliente"));
        importacao.setCpf(fieldSet.readString("cpf"));
        importacao.setNascimento(LocalDate.parse(fieldSet.readString("nascimento"), dateFormatter));
        importacao.setEvento(fieldSet.readString("evento"));
        importacao.setData(LocalDate.parse(fieldSet.readString("data"), dateFormatter));
        importacao.setTipoIngresso(fieldSet.readString("tipoIngresso"));
        importacao.setValor(fieldSet.readDouble("valor"));
        importacao.setHoraImportacao(LocalDateTime.now());

        return importacao;
    }

}
