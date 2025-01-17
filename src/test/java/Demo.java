import kr.jclab.javautils.systeminformation.SystemInformation;
import kr.jclab.javautils.systeminformation.model.OSArch;
import kr.jclab.javautils.systeminformation.model.OSInformation;
import kr.jclab.javautils.systeminformation.model.OSType;
import kr.jclab.javautils.systeminformation.smbios.DmiType;
import kr.jclab.javautils.systeminformation.smbios.SMBIOS;
import kr.jclab.javautils.systeminformation.smbios.SMBIOSReader;

public class Demo {
    public static void main(String[] args) throws Exception {
        // ==================== Read SMBIOS ====================
        SMBIOS smbios = new SMBIOS(); // Shared Object

        // Read really
        SMBIOSReader reader = new SMBIOSReader();
        smbios.read(reader);

        System.out.println("system : " + reader.getSmbiosInformation(DmiType.SYSTEM));
        System.out.println("baseboard : " + reader.getSmbiosInformation(DmiType.BASEBOARD));
        System.out.println("bios : " + reader.getSmbiosInformation(DmiType.BIOS));
        System.out.println("processor : " + reader.getSmbiosInformation(DmiType.PROCESSOR));
        System.out.println("memory : " + reader.getSmbiosInformation(DmiType.MEMORY_DEVICE));

        // ==================== SystemInformation ====================
        SystemInformation systemInformation = new SystemInformation();
        OSArch osArch = systemInformation.getOSArch();
        OSType osType = systemInformation.getOSType();
        OSInformation osInformation = systemInformation.getOSInformation();

        System.out.println("os arch : " + osArch.toString());
        System.out.println("os type : " + osType.toString());
        System.out.println("os info : " + osInformation.toString());
    }
}
