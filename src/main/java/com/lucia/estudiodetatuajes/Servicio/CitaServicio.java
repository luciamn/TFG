package com.lucia.estudiodetatuajes.Servicio;


import com.lucia.estudiodetatuajes.Modelo.Cita;
import com.lucia.estudiodetatuajes.Modelo.Cliente;
import com.lucia.estudiodetatuajes.Modelo.Personal;
import com.lucia.estudiodetatuajes.Repositorio.CitaRepo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CitaServicio {

    @Autowired
    private PersonalServicio personalServicio;

    @Autowired
    private CitaRepo citaRepo;

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    TipoTatuajeServicio tipoTatuajeServicio;

    @Autowired
    private EmailSenderService senderService;




@SneakyThrows
public Cita registrarCita(Cita cita, HttpSession session){

    Cliente c = (Cliente) session.getAttribute("usuario");
    Personal p = personalServicio.findByTipoTatuaje( tipoTatuajeServicio.findByTipo(cita.getTipo()));
    cita.setCliente(c);
    cita.setPersonal(p);

    senderService.enviarEmail(c.getEmail(), "Recordatorio de cita",
            "<!DOCTYPE html>\n" +
                    "\n" +
                    "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:th=\"http://www.thymeleaf.org\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Document</title>\n" +
                    "\n" +
                    "    <style type=\"text/css\">\n" +
                    "        body {\n" +
                    "        font-family: 'Crimson Text', serif;\n" +
                    "        }\n" +
                    "        \n" +
                    "        strong {\n" +
                    "        font-weight: 400 !important;\n" +
                    "        }\n" +
                    "        img{\n" +
                    "            filter: brightness(1.1);\n" +
                    "                mix-blend-mode: multiply;\n" +
                    "        }\n" +
                    "      #o{\n" +
                    "          \n" +
                    "          font-family: 'Square Peg', cursive;\n" +
                    "            font-size: 40px;\n" +
                    "            line-height: 30px;\n" +
                    "            color: bla;\n" +
                    "      }\n" +
                    "      @media screen and (max-width: 600px) {\n" +
                    "       table {\n" +
                    "           width:100%;\n" +
                    "                 }\n" +
                    "       thead {\n" +
                    "           display: none;\n" +
                    "       }\n" +
                    "       tbody td {\n" +
                    "           display: block;\n" +
                    "           text-align:center;\n" +
                    "           padding-right: 25px;\n" +
                    "       }\n" +
                    "       tbody td:before {\n" +
                    "           content: attr(data-th);\n" +
                    "           display: block;\n" +
                    "           text-align:center;\n" +
                    "       }\n" +
                    "\n" +
                    "       tbody td {\n" +
                    "           display: block;\n" +
                    "           text-align:center;\n" +
                    "       }\n" +
                    "}\n" +
                    "\n" +
                    "        \n" +
                    "      </style>\n" +
                    "\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <br>\n" +
                    "    <div style=\"overflow-x:auto;\">\n" +
                    "      <table  border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#fff\">\n" +
                    "        <tr>\n" +
                    "          <td align=\"center\" valign=\"top\" bgcolor=\"#fff\" style=\"background-color: #fff;\">\n" +
                    "            <!-- 600px container (white background) -->\n" +
                    "            <table border=\"0\" width=\"600\" cellpadding=\"0\" cellspacing=\"0\" class=\"container\" bgcolor=\"#ffffff\">\n" +
                    "              <tr>\n" +
                    "                <td class=\"container-padding\" bgcolor=\"#ffffff\" style=\"background-color: #ffffff; padding-left: 30px; font-size: 13px; line-height: 20px; font-family: Helvetica, sans-serif; color: #333; border: solid 1px #333;\" align=\"left\">\n" +
                    "                  <br>\n" +
                    "                  <!-- Header Logo -->\n" +
                    "                  <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"564\" align=\"left\">\n" +
                    "                    <tr>\n" +
                    "                      <td align=\"left\" valign=\"top\" style=\"font-size:13px; line-height: 20px; font-family: 'Lato', sans-serif;\">\n" +
                    "                        <p id=\"o\" style=\"text-align: center;\">Oveja Negra</p>\n" +
                    "                      </td>\n" +
                    "                    </tr>\n" +
                    "                  </table>\n" +
                    "                  <!-- End Header Logo -->\n" +
                    "\n" +
                    "                  <!-- End Navigation -->\n" +
                    "                  <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"564\" style=\"background-color: gray;\">\n" +
                    "                    <tbody>\n" +
                    "                      <tr>\n" +
                    "                        <td align=\"center\" valign=\"top\" style=\"font-family:'Crimson Text', serif;padding-bottom:20px;padding-top:80px;  font-size:30px; letter-spacing: 1px; text-align: center;color: #fff;\">Hola " + c.getNombre() + "</td>\n" +
                    "                      </tr>\n" +
                    "                      <tr>\n" +
                    "                        <td align=\"center\" valign=\"top\" style=\"padding-bottom: 10px;font-size:34px; letter-spacing: 1px;text-align: center;\">\n" +
                    "                          <p style=\"font-family:'Crimson Text', serif;font-size:15px;text-align: center;line-height: 30px;margin-top: 2px;color:#fff;padding-top: 10px;margin-bottom: 2px;\">Le recordamos su cita el dia " + cita.getFecha() + " a las " + cita.getHora() +
                                                " con el tatuador " + p.getNombre() + "</p>\n" +
                    "                          <p style=\"font-family:'Crimson Text', serif;font-size:15px;text-align: center;padding-bottom: 10px;line-height: 30px;margin-top: 2px;color:#fff;\">Si por cualquier circstancia no puede acudir a su cita, le rogamos que lo comunique o gestione su cita en la pagina web</p>\n" +
                    "                        </td>\n" +
                    "                      </tr>\n" +
                    "                      <tr>\n" +
                    "                        <td style=\"padding-bottom: 55px;text-align: center;\">\n" +
                    "                          <a href=\"#\">\n" +
                    "                            <img src='https://i2.wp.com/apoyomutuo.org/wp-content/uploads/2019/10/oveja_negra.png?fit=550%2C550' height=\"40\" color: alt=\"Track your package\" />\n" +
                    "                          </a>\n" +
                    "                        </td>\n" +
                    "                      </tr>\n" +
                    "                    </tbody>\n" +
                    "                  </table>\n" +
                    "                  \n" +
                    "                  <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"564\" style=\"padding-bottom: 50px;\">\n" +
                    "                    <thead>\n" +
                    "                      <tr>\n" +
                    "                        <th align=\"left\" width=\"282\" bgcolor=\"#EEE\" style=\"font-weight: bold;text-align: center;text-transform: uppercase; font-size:12px; letter-spacing: 2px; color:#333; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\">Informacion</th>\n" +
                    "                        <th width=\"15\"></th>\n" +
                    "                        <th align=\"left\" width=\"282\" bgcolor=\"#EEE\" style=\"font-weight: bold;text-align: center;text-transform: uppercase; font-size:12px; letter-spacing: 2px; color:#333; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\">Localizacion</th>\n" +
                    "                      </tr>\n" +
                    "                    </thead>\n" +
                    "                    <tbody>\n" +
                    "                      <tr>\n" +
                    "                        <td valign=\"top\" style=\"font-size:12px; padding:7px 9px 9px 9px; border-left:1px solid #EEE; border-bottom:1px solid #EEE; border-right:1px solid #EEE;\">\n" +
                    "                          <p style=\"font-size:13px; font-family: 'Crimson Text'; line-height:20px; margin:0; padding-bottom:10px;\">\n" +
                    "                              Existen hojas de reclamaciones a disposicion del consumidor\n" +
                    "                              <br>\n" +
                    "                              Claim forms are available at the disposal of the consumers and teh user.\n" +
                    "                        </td>\n" +
                    "                        <td>&nbsp;</td>\n" +
                    "                        <td valign=\"top\" style=\"font-size:12px; padding:7px 9px 9px 9px; border-left:1px solid #EEE; border-bottom:1px solid #EEE; border-right:1px solid #EEE;\">\n" +
                    "                          <p style=\"font-size:13px; font-family: 'Crimson Text'; line-height:24px; margin:0; padding-bottom:10px;\">\n" +
                    "                            <p>28037, Madrid</p>\n" +
                    "                            <p>San Blas</p>\n" +
                    "                          </p>\n" +
                    "                        </td>\n" +
                    "                      </tr>\n" +
                    "                    </tbody>\n" +
                    "                  </table>\n" +
                    "                  \n" +
                    "                  <!---footer-->\n" +
                    "                  <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin: 20px 0 0; padding: 20px 0; \" width=\"564\">\n" +
                    "                    <tr>\n" +
                    "                      <td valign=\"top\" style=\"text-align: center;\">\n" +
                    "                          <hr>\n" +
                    "                          <p>Si tiene alguna duda, pongase en contacto con nosotros</p>\n" +
                    "                        <a style=\"color: black;\" href=\"mailto:oveja.negra.sl.22@gmail.com\" target=\"_top\" style=\"display:inline-block\">\n" +
                    "                          Oveja Negra Support Mail\n" +
                    "                        </a>\n" +
                    "                      </td>\n" +
                    "                    </tr>\n" +
                    "                  </table>\n" +
                    "                  \n" +
                    "                  <!---footer-->\n" +
                    "                  <!-- BEGIN Copyright --->\n" +
                    "                  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"templateFooter\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;background-color: #ffffff;border-top: 0;border-bottom: 0; margin-top: 10px;\" width=\"600\">\n" +
                    "                    <tr>\n" +
                    "                      <td class=\"footerContainer\" style=\"padding-bottom: 9px;border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\" valign=\"top\">\n" +
                    "                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnTextBlock\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\" width=\"100%\">\n" +
                    "                          <tbody class=\"mcnTextBlockOuter\">\n" +
                    "                            <tr>\n" +
                    "                              <td class=\"mcnTextBlockInner\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\" valign=\"top\">\n" +
                    "                                <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"mcnTextContentContainer\" style=\"border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\" width=\"600\">\n" +
                    "                                  <tbody>\n" +
                    "                                    <tr>\n" +
                    "                                      <td class=\"mcnTextContent\" style=\"padding-top: 9px;padding-right: 30px;padding-bottom: 9px;border-collapse: collapse;mso-table-lspace: 0pt;mso-table-rspace: 0pt;color: #808080;font-family: Helvetica;font-size: 10px;line-height: 150%;text-align: center;\"\n" +
                    "                                        valign=\"top\">\n" +
                    "                                        <!-- Insert Fine Print Here/ Add Break After Paragraph -->\n" +
                    "                                        <!-- End Fine Print -->Copyright &copy; 2015 Artifact Uprising, LLC. All rights reserved.\n" +
                    "                                        <br/>You are receiving this email because you are a registered user of Artifact Uprising.\n" +
                    "                                        <br/>\n" +
                    "                                        <br/> <strong>\n" +
                    "                                                                                    Our mailing address is:\n" +
                    "                                                                                </strong>\n" +
                    "                                        <br/> <strong>  1644 South  Platte Street Denver, CO 80202 </strong>\n" +
                    "                                        <br/>\n" +
                    "                                        <a class=\"utilityLink\" href=\"http://artifactuprising.us5.list-manage1.com/vcard?u=baa942fc2b6775a20bd37f385&amp;id=80b8680e9c\" style=\"color: #606060;font-weight: normal;text-decoration: underline;word-wrap: break-word !important;\">Add us to your address book</a>\n" +
                    "                                        <br/>\n" +
                    "                                        <br/>\n" +
                    "                                        <br/>\n" +
                    "                                      </td>\n" +
                    "                                    </tr>\n" +
                    "                                  </tbody>\n" +
                    "                                </table>\n" +
                    "                              </td>\n" +
                    "                            </tr>\n" +
                    "                          </tbody>\n" +
                    "                        </table>\n" +
                    "                      </td>\n" +
                    "                    </tr>\n" +
                    "                  </table>\n" +
                    "                  <!-- END Copyright -->\n" +
                    "                </td>\n" +
                    "              </tr>\n" +
                    "            </table>\n" +
                    "    </div>\n" +
                    "\n" +
                    "    \n" +
                    "</body>\n" +
                    "</html>"
    );

    return citaRepo.save(cita);


}

    public ArrayList<Cita> CitaCliente(Long id){
        return citaRepo.findAllByClienteId(id);
    }

    public void eliminar(Long id){
        citaRepo.deleteById(id);
    }

    public boolean citasHoras(Cita cita) {
        List<Cita> SQL = citaRepo.citas();
        List<Cita> listCita = (List<Cita>) SQL;

        for(Cita lcita : listCita){
            if (lcita.getHora().equals(cita.getHora())){
                return true;
            }
        }
        return false;

    }

    public boolean citasFechas(Cita cita) {
        List<Cita> SQL = citaRepo.citas();
        List<Cita> listCita = (List<Cita>) SQL;

        for(Cita lcita : listCita){
            if (lcita.getFecha().equals(cita.getFecha())){
                return true;
            }
        }
        return false;

    }

    public Optional<Cita> listarId(long id){
    return citaRepo.findById(id);
    }
}
