package Mailing;

import java.util.HashMap;

public class MailTextGenerator
{
    private static MailTextGenerator Instance;
    private HashMap<MailType, MailText> mailTexts = new HashMap<>();

    public static MailTextGenerator GetInstance()
    {
        if(Instance == null)
        {
            Instance = new MailTextGenerator();
        }
        return Instance;
    }
    public record MailText(String subject, String body){}

    public void AddMailText(MailType type, MailText mailText)
    {
        mailTexts.put(type, mailText);
    }
    public String GetSubject(MailType mailType)
    {
        if(mailTexts.containsKey(mailType))
        {
            return mailTexts.get(mailType).subject;
        }
        return null;
    }
    public String GetBody(MailType mailType)
    {
        if(mailTexts.containsKey(mailType))
        {
            return mailTexts.get(mailType).body;
        }
        return null;
    }
}
