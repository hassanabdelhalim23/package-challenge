/*
 * Copyright 2018 Mondia Media Group GmbH. All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Mondia Media Group GmbH ("Confidential Information").
 * You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement
 * you entered into with Mondia Media Group GmbH.
 */
package com.mobiquityinc.packer.util;

import java.util.List;

import com.mobiquityinc.packer.bo.Package;

public interface PackerReader {

    List<Package> collectPackagesFromFile(String fileName);
}
