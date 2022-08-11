//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.service.impl;

import com.corrin.certshare.dao.ILogsProvinceApiRepository;
import com.corrin.certshare.entity.LogsProvinceApiEntity;
import com.corrin.certshare.service.ILogsProvinceApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogsProvinceApiServiceImpl implements ILogsProvinceApiService {
    @Autowired
    private ILogsProvinceApiRepository iLogsProvinceApiRepository;

    public LogsProvinceApiServiceImpl() {
    }

    public LogsProvinceApiEntity save(LogsProvinceApiEntity logsProvinceApiEntity) {
        LogsProvinceApiEntity save = (LogsProvinceApiEntity)this.iLogsProvinceApiRepository.save(logsProvinceApiEntity);
        return save;
    }
}
