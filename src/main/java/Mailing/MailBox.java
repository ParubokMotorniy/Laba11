package Mailing;

import java.util.ArrayList;

public class MailBox
{
    private MailSender sender;
    ArrayList<MailInfo> victims = new ArrayList<>();

    public MailBox(MailSender mySender)
    {
        sender = mySender;
    }
    public void AddTarget(MailInfo newTarget)
    {
        victims.add(newTarget);
    }

    public boolean BotherAll()
    {
        boolean success = true;
        for(MailInfo info : victims)
        {
            success = sender.SendMail(info) & success;
        }
        return success;
    }
}
