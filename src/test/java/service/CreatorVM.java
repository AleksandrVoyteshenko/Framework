package service;

import businessobjects.VirtualMachine;

public class CreatorVM {

    private static final String valueInstance = "testdata.valueInstance";
    private static final String valueOperatingSystem = "testdata.valueOperatingSystem";
    private static final String desiredResultVMClass = "testdata.desiredResultVMClass";
    private static final String valueSeries = "testdata.valueSeries";
    private static final String desiredResultInstanceType = "testdata.desiredResultInstanceType";
    private static final String desiredResultLocalSSD = "testdata.desiredResultLocalSSD";
    private static final String desiredResultRegion = "testdata.desiredResultRegion";
    private static final String desiredResultCommitmentTerm = "testdata.desiredResultCommitmentTerm";

    public static VirtualMachine getVirtualMachineWithDataFromProperties() {
        return new VirtualMachine(TestDataReader.getTestData(valueInstance), TestDataReader.getTestData(valueOperatingSystem),
                        TestDataReader.getTestData(desiredResultVMClass), TestDataReader.getTestData(valueSeries),
                        TestDataReader.getTestData(desiredResultInstanceType), TestDataReader.getTestData(desiredResultLocalSSD),
                        TestDataReader.getTestData(desiredResultRegion), TestDataReader.getTestData(desiredResultCommitmentTerm));
    }
}