package Object;

import java.io.IOException;
public class EqualsTest{
    public static void main(String[] args) throws Exception {
        //between -128 and 127, values refers to the same immutable object
        for (int i = -128; i < 128; i++){
            //
            Integer a = i;
            Integer b = i;
            if (a != b){
                throw new Exception("pas les mêmes objets");}
            }
        }
    }
