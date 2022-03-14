package BasicJava;

public class Tv {
    private boolean status;
    private int Volume;
    private int channelNumber;

    Tv(boolean _status,int _Volume,int _channelNumber){
        status=_status;
        channelNumber=_channelNumber;
        Volume =_Volume;
    }

    public void setVolume(int _Volume){
        Volume=_Volume;
    }
    public void setChannel(int _channelNumber){
        channelNumber =_channelNumber;
    }
    public void switchOn(){
        status=true;
    }
    public void switchOf(){
        status=false;
    }
}
