package by.jis4.komarov.bean;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class TV {
    public Logger log = LoggerFactory.getLogger(TV.class);

    private int channel;
    private int volume;
    private String brand;
    private boolean turnTV;
    private static final String TV_INFO_TURN_OFF = "TV turn off";

    public TV() {
    }

    public TV(int channel, int volume, String brand, boolean turnTV_On) {
        this.channel = channel;
        this.volume = volume;
        this.brand = brand;
        this.turnTV = turnTV_On;
    }

    public void switchChanellUp(){
        if (turnOnTv()){
            this.channel += 1;
        }else{
            log.info(TV_INFO_TURN_OFF);
        }
    }

    public void switchChanellDown(){
        if (turnOnTv()){
            this.channel -= 1;
        }else{
            log.info(TV_INFO_TURN_OFF);
        }
    }

    public void  increaseVolume(){
        if (turnOnTv()){
            this.volume += 1;
        }else{
            log.info(TV_INFO_TURN_OFF);
        }
    }

    public void decreaseVolume(){
        if (turnOnTv()){
            this.volume -= 1;
        }else{
            log.info(TV_INFO_TURN_OFF);
        }
    }

    public boolean turnOnTv(){
            this.turnTV = true;

        return true;
    }

    public boolean turnOffTv(){
        this.turnTV = false;

        return false;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isTurnTV() {
        return turnTV;
    }

    public void setTurnTV(boolean turnTV) {
            this.turnTV = turnTV;
        }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TV tv = (TV) o;
        return channel == tv.channel &&
                volume == tv.volume &&
                turnTV == tv.turnTV &&
                Objects.equals(brand, tv.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channel, volume, brand, turnTV);
    }

    @Override
    public String toString() {
        return "TV{" +
                "channel=" + channel +
                ", volume=" + volume +
                ", brand='" + brand + '\'' +
                ", turnTV=" + turnTV +
                '}';
    }
}
