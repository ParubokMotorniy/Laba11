package Mailing;

public class IDManager
{
    private int idCounter = 1;
    private static IDManager Instance;

    public static IDManager GetInstance()
    {
        if(Instance == null)
        {
            Instance = new IDManager();
        }
        return Instance;
    }
    private IDManager(){}

    public int AssignID()
    {
        idCounter ++;
        return (idCounter-1);
    }
}
