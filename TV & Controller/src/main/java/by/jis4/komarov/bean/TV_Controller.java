package by.jis4.komarov.bean;

public class TV_Controller  extends TV{
    private boolean toPlugToTV;


    public TV_Controller(int channel, int volume, String brand, boolean turnTV_On) {
        super(channel, volume, brand, turnTV_On);


    }

    public boolean isToPlugToTV() {
        return toPlugToTV;
    }

    public void setToPlugToTV(boolean toPlugToTV) {
        if (toPlugToTV == true) {
            this.toPlugToTV = toPlugToTV;
        }else{
            String NOT_TO_PLUG_TO_TV = "turn TV off";
            log.info(NOT_TO_PLUG_TO_TV);
        }
    }

    @Override
    public String toString() {
        return "TV_Controller{" +
                "toPlugToTV=" + toPlugToTV +
                '}';
    }
}
