package com.jds.testBase.yaml;

import java.util.List;

public class ModelBean {
    private List<ServiceDetails> Modeldetails;

    public void setModeldetails(List<ServiceDetails> modeldetails) {
        Modeldetails = modeldetails;
    }

    public List<ServiceDetails> getModeldetails() {
        return Modeldetails;
    }

    /**
     *  服务类
     */
    public static class ServiceDetails{
        private String Serial;
        private String System;
        private DeviceInfo deviceInfos;
        private AppiumParameter appiumParameters;
        private DockerParameter dockerParameters;

        public void setSerial(String serial) {
            Serial = serial;
        }

        public void setDeviceInfos(DeviceInfo deviceInfos) {
            this.deviceInfos = deviceInfos;
        }

        public void setAppiumParameters(AppiumParameter appiumParameters) {
            this.appiumParameters = appiumParameters;
        }

        public void setDockerParameters(DockerParameter dockerParameters) {
            this.dockerParameters = dockerParameters;
        }

        public String getSerial() {
            return Serial;
        }

        public DeviceInfo getDeviceInfos() {
            return deviceInfos;
        }

        public AppiumParameter getAppiumParameters() {
            return appiumParameters;
        }

        public DockerParameter getDockerParameters() {
            return dockerParameters;
        }

        public void setSystem(String system) {
            System = system;
        }

        public String getSystem() {
            return System;
        }

        /**
         * 设备信息
         */
        public static class DeviceInfo{
            private String Serial;
            private String Manufacturer;
            private String Model;
            private String Version;
            private String Height;
            private String Width;

            public void setSerial(String serial) {
                Serial = serial;
            }

            public void setManufacturer(String manufacturer) {
                Manufacturer = manufacturer;
            }

            public void setModel(String model) {
                Model = model;
            }

            public void setVersion(String version) {
                Version = version;
            }

            public void setHeight(String height) {
                Height = height;
            }

            public void setWidth(String width) {
                Width = width;
            }

            public String getSerial() {
                return Serial;
            }

            public String getManufacturer() {
                return Manufacturer;
            }

            public String getModel() {
                return Model;
            }

            public String getVersion() {
                return Version;
            }

            public String getHeight() {
                return Height;
            }

            public String getWidth() {
                return Width;
            }
        }

        /**
         *  Appiun参数
         */
        public static class AppiumParameter{
            private String port;
            private String bp;
            private String chromedrniverport;

            public void setPort(String port) {
                this.port = port;
            }

            public void setBp(String bp) {
                this.bp = bp;
            }

            public void setChromedrniverport(String chromedrniverport) {
                this.chromedrniverport = chromedrniverport;
            }

            public String getPort() {
                return port;
            }

            public String getBp() {
                return bp;
            }

            public String getChromedrniverport() {
                return chromedrniverport;
            }
        }

        /**
         *  Docker镜像参数
         */
        public static class DockerParameter{
            private String image;
            private String containerName;

            public void setImage(String image) {
                this.image = image;
            }

            public void setContainerName(String containerName) {
                this.containerName = containerName;
            }

            public String getImage() {
                return image;
            }

            public String getContainerName() {
                return containerName;
            }
        }
    }
}
