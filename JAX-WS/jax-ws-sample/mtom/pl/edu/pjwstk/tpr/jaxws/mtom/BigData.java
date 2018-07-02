package pl.edu.pjwstk.tpr.jaxws.mtom;

import java.security.SecureRandom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.PROPERTY)
public class BigData {

    private static SecureRandom _random;
    private static final int DEFAULT_RAW_DATA_SIZE = 0x10000; // 64kB

    static {
        try {
            _random = SecureRandom.getInstanceStrong();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    public static BigData generate() {
        byte[] data = generateRawData(DEFAULT_RAW_DATA_SIZE);
        return new BigData(data);
    }

    private static byte[] generateRawData(int size) {
        byte[] data = new byte[size];
        _random.nextBytes(data);
        return data;
    }

    @XmlTransient
    private int _size;

    @XmlTransient
    private byte[] _rawData;

    private BigData(byte[] rawData) {
        _rawData = rawData;
        _size = (_rawData != null) ? _rawData.length : 0;
    }

    @XmlElement
    public int getSize() {
        return _size;
    }

    @XmlElement
    public void setSize(int size) {
        _size = size;
    }

    @XmlElement
    public byte[] getRawData() {
        return _rawData;
    }

    @XmlElement
    public void setRawData(byte[] rawData) {
        _rawData = rawData;
    }
}