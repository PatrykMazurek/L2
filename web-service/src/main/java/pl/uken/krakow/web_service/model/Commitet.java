package pl.uken.krakow.web_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Commitet {
    String appointmentDate;
    String code;
    String compositionDate;
    Members[] members;
    String name;
    String nameGenitive;
    String phone;
    String scope;
    String type;
}
