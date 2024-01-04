public class BitString {
    private byte[] data;

    public BitString(int length) {
        int dataSize = (length + 7) / 8; // Размер массива байтов для хранения битов
        data = new byte[dataSize];
    }

    public void setBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex >= data.length * 8) {
            throw new IllegalArgumentException("Недопустимый индекс бита");
        }

        int byteIndex = bitIndex / 8;
        int bitOffset = bitIndex % 8;
        data[byteIndex] |= (1 << bitOffset);
    }

    public void clearBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex >= data.length * 8) {
            throw new IllegalArgumentException("Недопустимый индекс бита");
        }

        int byteIndex = bitIndex / 8;
        int bitOffset = bitIndex % 8;
        data[byteIndex] &= ~(1 << bitOffset);
    }

    public boolean getBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex >= data.length * 8) {
            throw new IllegalArgumentException("Недопустимый индекс бита");
        }

        int byteIndex = bitIndex / 8;
        int bitOffset = bitIndex % 8;
        return ((data[byteIndex] >> bitOffset) & 1) == 1;
    }

    public void shiftLeft(int count) {
        // Циклический сдвиг влево на count бит
        for (int i = 0; i < count; i++) {
            int lastBit = getBit(data.length * 8 - 1) ? 1 : 0;
            for (int j = data.length * 8 - 1; j > 0; j--) {
                if (getBit(j - 1)) {
                    setBit(j);
                } else {
                    clearBit(j);
                }
            }
            if (lastBit == 1) {
                setBit(0);
            } else {
                clearBit(0);
            }
        }
    }

    public void shiftRight(int count) {
        // Циклический сдвиг вправо на count бит
        for (int i = 0; i < count; i++) {
            int firstBit = getBit(0) ? 1 : 0;
            for (int j = 0; j < data.length * 8 - 1; j++) {
                if (getBit(j + 1)) {
                    setBit(j);
                } else {
                    clearBit(j);
                }
            }
            if (firstBit == 1) {
                setBit(data.length * 8 - 1);
            } else {
                clearBit(data.length * 8 - 1);
            }
        }
    }

    public void and(BitString other) {
        // Поразрядное "и" с другой битовой строкой
        for (int i = 0; i < data.length; i++) {
            data[i] &= other.data[i];
        }
    }

    public void or(BitString other) {
        // Поразрядное "или" с другой битовой строкой
        for (int i = 0; i < data.length; i++) {
            data[i] |= other.data[i];
        }
    }

    public void xor(BitString other) {
        // Поразрядное "исключающее или" с другой битовой строкой
        for (int i = 0; i < data.length; i++) {
            data[i] ^= other.data[i];
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = data.length - 1; i >= 0; i--) {
            String binary = String.format("%8s", Integer.toBinaryString(data[i] & 0xFF)).replace(' ', '0');
            builder.append(binary);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        BitString bitString = new BitString(16);
        bitString.setBit(0);
        bitString.setBit(3);
        bitString.setBit(7);
        System.out.println("BitString: " + bitString.toString());

        BitString other = new BitString(16);
        other.setBit(2);
        other.setBit(7);
        other.setBit(10);
        System.out.println("Other BitString: " + other.toString());

        bitString.and(other);
        System.out.println("BitString AND Other: " + bitString.toString());

        bitString.or(other);
        System.out.println("BitString OR Other: " + bitString.toString());

        bitString.xor(other);
        System.out.println("BitString XOR Other: " + bitString.toString());

        bitString.shiftLeft(2);
        System.out.println("BitString Shifted Left: " + bitString.toString());

        bitString.shiftRight(2);
        System.out.println("BitString Shifted Right: " + bitString.toString());
    }
}
