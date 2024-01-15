package sorces;

import lombok.Data;
import lombok.Value;


public enum Gender {
       MALE("Мужчина"), FEMALE("Женьщина");
       private String gender;
       Gender(String gender){
              this.gender = gender;
       }

       public String getGender() {
              return gender;
       }
}
