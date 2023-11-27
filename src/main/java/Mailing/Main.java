package Mailing;

public class Main
{
    public static void main(String[] args)
    {
        MailTextGenerator.GetInstance().AddMailText(MailType.Greeting, new MailTextGenerator.MailText("Greetings!", "We are truly glad to wish you all the best. Otherwise, who would keep our business going?"));
        MailTextGenerator.GetInstance().AddMailText(MailType.NastyPromo, new MailTextGenerator.MailText("Hi there!", "It is our pleasure to inform you that we have just released a brand-new totally useless trinket that you will anyway get as dictated by our consumerist and conformist society. Now at discount price! Hurry!"));
        MailTextGenerator.GetInstance().AddMailText(MailType.DebtThreat, new MailTextGenerator.MailText("Hi!", "Where is the money, Lebowski?"));

        MailBox box = new MailBox(new MailSender());
        box.BotherAll();
    }
}
