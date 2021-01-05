package service;

import businessobjects.VirtualMachine;

public class CreatorVM {

    private static final String valueInstance = TestDataReader.getTestData("testdata.valueInstance");
    private static final String valueOperatingSystem = TestDataReader.getTestData("testdata.valueOperatingSystem");
    private static final String desiredResultVMClass = TestDataReader.getTestData("testdata.desiredResultVMClass");
    private static final String valueSeries = TestDataReader.getTestData("testdata.valueSeries");
    private static final String desiredResultInstanceType = TestDataReader.getTestData("testdata.desiredResultInstanceType");
    private static final String desiredResultLocalSSD = TestDataReader.getTestData("testdata.desiredResultLocalSSD");
    private static final String desiredResultRegion = TestDataReader.getTestData("testdata.desiredResultRegion");
    private static final String desiredResultCommitmentTerm = TestDataReader.getTestData("testdata.desiredResultCommitmentTerm");

    public static VirtualMachine getVirtualMachineWithAllParameters() {
        return new VirtualMachine(valueInstance, valueOperatingSystem, desiredResultVMClass, valueSeries,
                desiredResultInstanceType, desiredResultLocalSSD, desiredResultRegion, desiredResultCommitmentTerm);
    }
}