package Proxy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProxyImage implements MyImage
{
    public String filename;
    @Override
    public void display()
    {
        RealImage initiatedImage = new RealImage(filename);
        initiatedImage.display();
    }
}
