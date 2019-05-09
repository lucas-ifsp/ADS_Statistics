package br.edu.ifsp.poos3.utils;

import br.edu.ifsp.poos3.model.ClassStatistics;

import java.util.LinkedHashMap;
import java.util.Map;

public class StatisticsHelper {

    public static Map<String, ClassStatistics> init() {
        Map<String, ClassStatistics> map = new LinkedHashMap<>();

        map.put("ADMT1", new ClassStatistics("ADMT1"));
        map.put("FMTT1", new ClassStatistics("FMTT1"));
        map.put("IBST1", new ClassStatistics("IBST1"));
        map.put("IGTT1", new ClassStatistics("IGTT1"));
        map.put("LOGT1", new ClassStatistics("LOGT1"));
        map.put("CMET1", new ClassStatistics("CMET1"));

        map.put("FOCT2", new ClassStatistics("FOCT2"));
        map.put("ENGT2", new ClassStatistics("ENGT2"));
        map.put("BD1T2", new ClassStatistics("BD1T2"));
        map.put("LP1T2", new ClassStatistics("LP1T2"));
        map.put("ISOT2", new ClassStatistics("ISOT2"));

        map.put("GPST3", new ClassStatistics("GPST3"));
        map.put("BD2T3", new ClassStatistics("BD2T3"));
        map.put("EPOT3", new ClassStatistics("EPOT3"));
        map.put("PEST3", new ClassStatistics("PEST3"));
        map.put("LP2T3", new ClassStatistics("LP2T3"));

        map.put("AOOT4", new ClassStatistics("AOOT4"));
        map.put("LP3T4", new ClassStatistics("LP3T4"));
        map.put("SIGT4", new ClassStatistics("SIGT4"));
        map.put("OPET4", new ClassStatistics("OPET4"));
        map.put("RC1T4", new ClassStatistics("RC1T4"));

        map.put("DW1T5", new ClassStatistics("DW1T5"));
        map.put("POOT5", new ClassStatistics("POOT5"));
        map.put("MP1T5", new ClassStatistics("MP1T5"));
        map.put("RC2T5", new ClassStatistics("RC2T5"));

        map.put("PRJT6", new ClassStatistics("PRJT6"));
        map.put("DW2T6", new ClassStatistics("DW2T6"));
        map.put("SEGT6", new ClassStatistics("SEGT6"));
        map.put("GCET6", new ClassStatistics("GCET6"));
        map.put("MP2T6", new ClassStatistics("MP2T6"));

        map.put("AP1S1", new ClassStatistics("AP1S1"));
        map.put("ARCS1", new ClassStatistics("ARCS1"));
        map.put("CE1S1", new ClassStatistics("CE1S1"));
        map.put("MATS1", new ClassStatistics("MATS1"));
        map.put("INWS1", new ClassStatistics("INWS1"));
        map.put("IG1S1", new ClassStatistics("IG1S1"));
        map.put("ADMS1", new ClassStatistics("ADMS1"));

        map.put("AP2S2", new ClassStatistics("AP2S2"));
        map.put("CE2S2", new ClassStatistics("CE2S2"));
        map.put("IG2S2", new ClassStatistics("IG2S2"));
        map.put("MACS2", new ClassStatistics("MACS2"));
        map.put("SOPS2", new ClassStatistics("SOPS2"));
        map.put("SINS2", new ClassStatistics("SINS2"));
        map.put("PW1S2", new ClassStatistics("PW1S2"));

        map.put("BD1S3", new ClassStatistics("BD1S3"));
        map.put("ESWS3", new ClassStatistics("ESWS3"));
        map.put("ESDS3", new ClassStatistics("ESDS3"));
        map.put("POOS3", new ClassStatistics("POOS3"));
        map.put("PW2S3", new ClassStatistics("PW2S3"));

        map.put("BD2S4", new ClassStatistics("BD2S4"));
        map.put("DOOS4", new ClassStatistics("DOOS4"));
        map.put("IHCS4", new ClassStatistics("IHCS4"));
        map.put("MPCS4", new ClassStatistics("MPCS4"));
        map.put("PW3S4", new ClassStatistics("PW3S4"));
        map.put("RC1S4", new ClassStatistics("RC1S4"));

        map.put("GPSS5", new ClassStatistics("GPSS5"));
        map.put("ESTS5", new ClassStatistics("ESTS5"));
        map.put("PDMS5", new ClassStatistics("PDMS5"));
        map.put("PW4S5", new ClassStatistics("PW4S5"));
        map.put("RC2S5", new ClassStatistics("RC2S5"));
        map.put("TC1S5", new ClassStatistics("TC1S5"));

        map.put("SEGS6", new ClassStatistics("SEGS6"));
        map.put("CSSS6", new ClassStatistics("CSSS6"));
        map.put("FAIS6", new ClassStatistics("FAIS6"));
        map.put("EMPS6", new ClassStatistics("EMPS6"));
        map.put("PRSS6", new ClassStatistics("PRSS6"));
        map.put("TC2S6", new ClassStatistics("TC2S6"));

        return map;
    }
}
