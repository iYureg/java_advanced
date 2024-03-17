package gb.junior.webinar_2_reflection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import gb.junior.Webinar_1_lambda_and_stream_API.Streams;

import java.io.IOException;

public class JacksonDemo {
    public static void main(String[] args) throws IOException {
//        Streams.Person person = new Streams.Person("Igor", 25, 10_000, new Streams.Department("gb"));
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String s = objectMapper.writer().withDefaultPrettyPrinter().writeValueAsString(person);
//        System.out.println(s);
//
//        ObjectReader reader = objectMapper.reader();
//        Streams.Person obj = reader.readValue("{\n" +
//                "  \"name\" : \"Igor\",\n" +
//                "  \"age\" : 25,\n" +
//                "  \"salary\" : 10000.0,\n" +
//                "  \"department\" : {\n" +
//                "    \"name\" : \"gb\"\n" +
//                "  }\n" +
//                "}", Streams.Person.class);
//
//        System.out.println(obj.toString());


        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter writer = objectMapper.writer().withDefaultPrettyPrinter();

        Student student = new Student();
        student.setFirstName("Igor");
        student.setSecondName("Chestnov");
        String jsonIgorChes = writer.writeValueAsString(student);
        System.out.println(jsonIgorChes);

        Student readedIgorChes = objectMapper.reader().readValue(jsonIgorChes, Student.class);
        System.out.println(readedIgorChes);

        Student readedStudent = objectMapper.reader().readValue("""
            {
            "first_name": "1"
            }
            """, Student.class);

        System.out.println(readedStudent.toString());
    }

    private static class Student {
        @JsonProperty(value = "first_name")
        private String firstName;
        @JsonProperty("surname")
        private String secondName;

        public Student() {
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getSecondName() {
            return secondName;
        }

        public void setSecondName(String secondName) {
            this.secondName = secondName;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "firstName='" + firstName + '\'' +
                    ", secondName='" + secondName + '\'' +
                    '}';
        }
    }
}
