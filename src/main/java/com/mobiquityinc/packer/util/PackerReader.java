
package com.mobiquityinc.packer.util;

import java.util.List;

import com.mobiquityinc.packer.bo.Package;

public interface PackerReader {

    List<Package> collectPackagesFromFile(String fileName);
}
