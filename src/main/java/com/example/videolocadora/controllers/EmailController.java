package com.example.videolocadora.controllers;

import com.example.videolocadora.dtos.EmailDto;
import com.example.videolocadora.models.ClienteModel;
import com.example.videolocadora.models.EmailModel;
import com.example.videolocadora.models.LocacaoModel;
import com.example.videolocadora.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDto emailDto){

        EmailModel emailModel = new EmailModel();
        LocacaoModel locacacaoModel = new LocacaoModel();
        ClienteModel clienteModel = new ClienteModel();
        emailModel.setEmailFrom("jardel.silva0206@gmail.com");
        emailModel.setOwnerRef("jardel.silva0206@gmail.com");
        emailModel.setEmailTo(clienteModel.getEmail());
        emailModel.setSubject("Confirmação de locação");
        emailModel.setText("Olá "+clienteModel.getNomeCliente()+" este email é uma confirmação de locação do filme " +
                locacacaoModel.getIdFilme()+" que deve ser devolvido no dia "+locacacaoModel.getDataDevolucao());
        BeanUtils.copyProperties(emailDto, emailModel);

        emailService.sendEmail(emailModel);

        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }
}
