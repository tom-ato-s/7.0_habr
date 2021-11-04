import java.util.ArrayList;
//класс переводит строку в массив слов
class StringToWords {
    private String s;
    private ArrayList<String> arrWords;
    private int l;

    StringToWords(String s) { //конструктор класса, принимает строку
        this.s = s;
        arrWords = new ArrayList<>();
        l = s.length();
    }

    public void doArrWords() {   // метод переводит строку в массив слов
        StringBuilder word = new StringBuilder();   // временная переменная для формирования слова
        char tempChar;  //временная переменная для знака из строку

      for(int i = 0; i<l; i++) {  //перебор входящей строки
          tempChar = s.charAt(i);
          if(isWord(tempChar)) { // проверяем знак буква русского алфавита?
              word.append(tempChar);
          } else {

          //если знак не первый и не синтаксический знак, и предыдущий знак был буквой-то
          // собранное слово отправляется в массив слов
            if( (i != 0) & (isWord(s.charAt(i-1)))) {
                 if ((isZnak(tempChar)) || (tempChar == ' ') || (tempChar == '\n') || (tempChar == '\t')) {
                 arrWords.add(word.toString()); // отправка слова в массив
                  word = new StringBuilder("");   // обнуления переменной для слова
                 }
            }
         }
      }

    }

    private boolean isWord(char ch) { //сравнение входящего char со всеми буквами русского алфавита
        boolean flag = false;
        char bukva = 'А';
        if (ch == 'ё') {
            flag = true;
        } else {
            for (int i = 0; i < 66; i++) {
                if (ch == bukva) {
                    flag = true;
                    break;
                } else bukva++;
            }
        }return flag;
    }


    private boolean isZnak(char ch) { //сравнение входящего char со всеми синтаксическими знаками
        boolean flag = false;
        char znak = '!';  //перебор всех знаков

        for(int i = 0; i<15; i++) {
            if(ch == znak) {
                flag = true; break;
            }else znak++;
        }return flag;
    }

    public String [] getArrWords() { // возврат сформировванного массивамассива
        String [] st = new String[arrWords.size()];
        for (int i = 0; i<arrWords.size(); i++) {
            st[i] = arrWords.get(i);
        }
        return st;
    }
}
