public class dict {
    void createDict(String text) {
        text = text.toLowerCase();

        int[] conv_text = new int['я' - 'а' + 1];
        for(int i = 0; i < text.length(); i++){
            char chr = text.charAt(i);
            if(chr >= 'а' && chr <= 'я'){
                conv_text[chr - 'а']++;
            }
        }

        for(int i = 0; i < conv_text.length; i++){
            System.out.println((char) (i + 'а') + " = " + conv_text[i]);
        }

    }

}
