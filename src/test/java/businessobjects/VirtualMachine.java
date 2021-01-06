package businessobjects;

public class VirtualMachine {

    private String valueInstance;
    private String valueOperatingSystem;
    private String desiredResultVMClass;
    private String valueSeries;
    private String desiredResultInstanceType;
    private String desiredResultLocalSSD;
    private String desiredResultRegion;
    private String desiredResultCommitmentTerm;

    public VirtualMachine(String valueInstance, String valueOperatingSystem, String desiredResultVMClass, String valueSeries,
                          String desiredResultInstanceType, String desiredResultLocalSSD, String desiredResultRegion, String desiredResultCommitmentTerm) {
        this.valueInstance = valueInstance;
        this.valueOperatingSystem = valueOperatingSystem;
        this.desiredResultVMClass = desiredResultVMClass;
        this.valueSeries = valueSeries;
        this.desiredResultInstanceType = desiredResultInstanceType;
        this.desiredResultLocalSSD = desiredResultLocalSSD;
        this.desiredResultRegion = desiredResultRegion;
        this.desiredResultCommitmentTerm = desiredResultCommitmentTerm;
    }

    public VirtualMachine() {
    }

    public String getValueInstance() {
        return valueInstance;
    }

    public void setValueInstance(String valueInstance) {
        this.valueInstance = valueInstance;
    }

    public String getValueOperatingSystem() {
        return valueOperatingSystem;
    }

    public void setValueOperatingSystem(String valueOperatingSystem) {
        this.valueOperatingSystem = valueOperatingSystem;
    }

    public String getDesiredResultVMClass() {
        return desiredResultVMClass;
    }

    public void setDesiredResultVMClass(String desiredResultVMClass) {
        this.desiredResultVMClass = desiredResultVMClass;
    }

    public String getValueSeries() {
        return valueSeries;
    }

    public void setValueSeries(String valueSeries) {
        this.valueSeries = valueSeries;
    }

    public String getDesiredResultInstanceType() {
        return desiredResultInstanceType;
    }

    public void setDesiredResultInstanceType(String desiredResultInstanceType) {
        this.desiredResultInstanceType = desiredResultInstanceType;
    }

    public String getDesiredResultLocalSSD() {
        return desiredResultLocalSSD;
    }

    public void setDesiredResultLocalSSD(String desiredResultLocalSSD) {
        this.desiredResultLocalSSD = desiredResultLocalSSD;
    }

    public String getDesiredResultRegion() {
        return desiredResultRegion;
    }

    public void setDesiredResultRegion(String desiredResultRegion) {
        this.desiredResultRegion = desiredResultRegion;
    }

    public String getDesiredResultCommitmentTerm() {
        return desiredResultCommitmentTerm;
    }

    public void setDesiredResultCommitmentTerm(String desiredResultCommitmentTerm) {
        this.desiredResultCommitmentTerm = desiredResultCommitmentTerm;
    }
}