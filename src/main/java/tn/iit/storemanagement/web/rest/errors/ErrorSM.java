package tn.iit.storemanagement.web.rest.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
public class ErrorSM  {
    private String message;
    private String conflict;
}
