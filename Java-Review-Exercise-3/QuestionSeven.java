import java.util.Scanner;

class RemoveString
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = in.nextLine();
        System.out.println("Enter a string to remove from the sentence: ");
        String str = in.nextLine();
        in.close();
        String output = removeString(sentence, str);
        System.out.println(output);
    }

    public static String removeString(String sentence, String str )
    {
        if (sentence.contains(str))
        {
            sentence = sentence.replace(str, "");
            removeString(sentence, str);
        }
        return sentence;
    }
}

