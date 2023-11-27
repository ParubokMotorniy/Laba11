package Proxy;

import Proxy.MyImage;
import Proxy.RealImage;

public class Main
{
    public static void main(String[] args)
    {
        MyImage img = new ProxyImage("C:\\Users\\Lenovo\\OneDrive\\Pictures\\Screenshots\\photo.png");
        img.display();
    }
}
