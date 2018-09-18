/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.project;

import java.util.ArrayList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationResult;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import org.controlsfx.validation.decoration.CompoundValidationDecoration;
import org.controlsfx.validation.decoration.StyleClassValidationDecoration;


public class TextFieldValidator {
        public static final int NUMBER=0,STRING=1,BOTH=2;
        ArrayList <ValidationSupport> validators =new ArrayList<>();
        
    public boolean checkValidators(){
        for(ValidationSupport ele :validators)
            if(ele.isInvalid())
                return true;
        
        return false;
    }
    
    public void validateTextFields(TextField t,int type){
    ValidationSupport support = new ValidationSupport();
    
    Validator<String> validator = new Validator<String>()
    {
      @Override
      public ValidationResult apply( Control control, String value )
      {
          
          boolean valueMatches=false;
                switch(type)
      {
          case NUMBER:
              valueMatches=value.matches("[0-9]+");
              break;
          case STRING:
              valueMatches=value.matches("[a-zA-Z]+");
              break;
              
          case BOTH:
              valueMatches=!value.matches("");
              break;
          default:
              
      }
                
          boolean condition;
          condition=value!=null? !valueMatches:false;
          

        return ValidationResult.fromMessageIf( control, "not a String", Severity.ERROR, condition );
      }
    };
    validators.add(support);
    support.registerValidator( t, true, validator );
    }
    
    public void validateComboBoxes(ComboBox cb){
        ValidationSupport support = new ValidationSupport();
        Validator<String> validator = new Validator<String>() {
            @Override
            public ValidationResult apply(Control control, String value) {
                
                boolean condition=value==null;
                
                System.out.println(condition);
                return ValidationResult.fromMessageIf( control, "not a String", Severity.ERROR, condition );
            }
        };

       
    validators.add(support);
    support.registerValidator( cb, true, validator );
    }
    
    
}
