package net.juancarlosfernandez.myfilms.utils.filmaffinity;

import net.juancarlosfernandez.myfilms.utils.filmaffinity.FileProperties;

import java.io.RandomAccessFile;

class FilePropertiesIFO extends FileProperties {

    private final int DVDVIDEO_VTS = 0x535456; /* 'VTS' */

    private final int SIZE = 100000;

    /**
     * Processes a file from the given DataInputStream.
     */
    protected void process(RandomAccessFile dataStream) throws Exception {
        //log.finest("Start processing IFO file.");

        byte[] ifoFile = new byte[SIZE + 10];

        /*
         * 4 bytes has already been read in FilePropertiesMovie, therefore the
         * first byte read is stored in index 4
         */
        dataStream.read(ifoFile, 4, SIZE);

        /* Gets the stream type... (4 bytes) */
        int streamType = readUnsignedInt32(ifoFile, 9);

        if (streamType == DVDVIDEO_VTS) {

            supported = true;
            processIfoFile(ifoFile);

            //log.finest("Processing IFO file done.");
        } else {
            log.finest("IFO type (" + Integer.toString(streamType) + ") not supported. Expecting (" + Integer.toString(DVDVIDEO_VTS) + ")");
        }
    }

    void processIfoFile(byte[] ifoFile) throws Exception {
        getRuntime(ifoFile);
    }

    void getRuntime(byte[] ifoFile) throws Exception {

        int[] runtime;
        int mainRuntime = 0;

        /* sector pointer to VTS_PGCI (Title Program Chain table) Offset 204 */
        int sectorPointerVTS_PGCI = changeEndianness(readUnsignedInt32(ifoFile,
                204));

        /*
         * Offset value of the VTS_PGCITI (Video title set program chain
         * information table)
         */
        int offsetVTS_PGCI = sectorPointerVTS_PGCI * 2048;

        int numberOfTitles = readUnsignedInt16(ifoFile, offsetVTS_PGCI + 1);

        runtime = new int[numberOfTitles];

        // int startByteVTS_PGCI = offsetVTS_PGCI;

        int pointer = offsetVTS_PGCI;
        int startcode = changeEndianness(readUnsignedInt32(ifoFile,
                offsetVTS_PGCI + 12));

        offsetVTS_PGCI += 12;

        for (int i = 0; i < numberOfTitles; i++) {

            runtime[i] = 0;

            runtime[i] += encode(ifoFile[pointer + startcode + 4]) * 60 * 60; /* Hours */
            runtime[i] += encode(ifoFile[pointer + startcode + 5]) * 60; /* Minutes */
            runtime[i] += encode(ifoFile[pointer + startcode + 6]); /* Seconds */

            if (mainRuntime < runtime[i]) {
                mainRuntime = runtime[i];
            }

            /* Encrease by 8 to get to the next startcode */
            offsetVTS_PGCI += 8;
            startcode = changeEndianness(readUnsignedInt32(ifoFile,
                    offsetVTS_PGCI));
        }

        setDuration(mainRuntime);
    }

    public static int encode(byte dataByte) {
        StringBuilder builder = new StringBuilder();

        // A byte stand for 2 hex characters
        builder.append(Integer.toHexString((dataByte & 0xF0) >> 4));
        builder.append(Integer.toHexString(dataByte & 0x0F));

        return Integer.parseInt(builder.toString());
    }
}
