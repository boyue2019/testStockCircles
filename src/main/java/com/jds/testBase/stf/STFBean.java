package com.jds.testBase.stf;

import java.util.List;

public class STFBean {

    /**
     * success : true
     * devices : [{"abi":"arm64-v8a","airplaneMode":false,"battery":{"health":"good","level":42,"scale":100,"source":"usb","status":"charging","temp":36,"voltage":3.81},"browser":{"apps":[{"id":"com.android.browser/.BrowserActivity","name":"Browser","selected":false,"system":true,"type":"android-browser","developer":"Google Inc."}],"selected":false},"channel":"ifHjSc1spCJ/HBvCHPkxICWoTUY=","cpuPlatform":"msm8996","createdAt":"2019-07-11T05:52:20.018Z","display":{"density":3,"fps":60.000003814697266,"height":1920,"id":0,"rotation":0,"secure":true,"size":5.147105693817139,"url":"ws://localhost:7412","width":1080,"xdpi":428.625,"ydpi":427.78900146484375},"manufacturer":"XIAOMI","model":"MI 5","network":{"connected":true,"failover":false,"roaming":false,"subtype":"","type":"WIFI"},"openGLESVersion":"3.1","operator":",","owner":null,"phone":{"iccid":null,"imei":"862033032250027","imsi":null,"network":"UNKNOWN","phoneNumber":null},"platform":"Android","presenceChangedAt":"2019-07-17T06:51:05.368Z","present":false,"product":"gemini","provider":{"channel":"OVNcX4Y4QWqDWm51EKC1AA==","name":"boyuedeMacBook-Pro.local"},"ready":true,"remoteConnect":false,"remoteConnectUrl":null,"reverseForwards":[],"sdk":"23","serial":"edd06f8e","status":3,"statusChangedAt":"2019-07-17T06:47:28.639Z","usage":null,"usageChangedAt":"2019-07-17T06:46:25.949Z","version":"6.0","using":false},{"abi":"arm64-v8a","airplaneMode":false,"battery":{"health":"good","level":56,"scale":100,"source":"usb","status":"charging","temp":26.5,"voltage":3.943},"browser":{"apps":[{"id":"com.android.browser/.BrowserActivity","name":"Browser","selected":true,"system":true,"type":"android-browser","developer":"Google Inc."}],"selected":true},"channel":"iTprhZ8qSm0wysEnm64Cu/FveQU=","cpuPlatform":"msmnile","createdAt":"2019-07-11T05:45:14.685Z","display":{"density":2.75,"fps":60.000003814697266,"height":2340,"id":0,"rotation":0,"secure":true,"size":6.376625061035156,"url":"ws://localhost:7412","width":1080,"xdpi":403.4110107421875,"ydpi":404.32598876953125},"manufacturer":"XIAOMI","model":"MI 9","network":{"connected":true,"failover":false,"roaming":false,"subtype":"","type":"WIFI"},"openGLESVersion":"3.2","operator":",中国移动","owner":null,"phone":{"iccid":"898600790916F4008071","imei":"860682040008850","imsi":"460005462978710","network":"LTE","phoneNumber":null},"platform":"Android","presenceChangedAt":"2019-07-15T11:35:18.704Z","present":false,"product":"cepheus","provider":{"channel":"S1r3jhGpQ5uLdWGoTAMfnA==","name":"boyuedeMacBook-Pro.local"},"ready":true,"remoteConnect":false,"remoteConnectUrl":null,"reverseForwards":[],"sdk":"28","serial":"6d4a5e0d","status":3,"statusChangedAt":"2019-07-15T11:24:04.356Z","usage":null,"usageChangedAt":"2019-07-15T11:34:41.387Z","version":"9","using":false}]
     */

    private boolean success;
    private List<DevicesBean> devices;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DevicesBean> getDevices() {
        return devices;
    }

    public void setDevices(List<DevicesBean> devices) {
        this.devices = devices;
    }

    public static class DevicesBean {
        /**
         * abi : arm64-v8a
         * airplaneMode : false
         * battery : {"health":"good","level":42,"scale":100,"source":"usb","status":"charging","temp":36,"voltage":3.81}
         * browser : {"apps":[{"id":"com.android.browser/.BrowserActivity","name":"Browser","selected":false,"system":true,"type":"android-browser","developer":"Google Inc."}],"selected":false}
         * channel : ifHjSc1spCJ/HBvCHPkxICWoTUY=
         * cpuPlatform : msm8996
         * createdAt : 2019-07-11T05:52:20.018Z
         * display : {"density":3,"fps":60.000003814697266,"height":1920,"id":0,"rotation":0,"secure":true,"size":5.147105693817139,"url":"ws://localhost:7412","width":1080,"xdpi":428.625,"ydpi":427.78900146484375}
         * manufacturer : XIAOMI
         * model : MI 5
         * network : {"connected":true,"failover":false,"roaming":false,"subtype":"","type":"WIFI"}
         * openGLESVersion : 3.1
         * operator : ,
         * owner : null
         * phone : {"iccid":null,"imei":"862033032250027","imsi":null,"network":"UNKNOWN","phoneNumber":null}
         * platform : Android
         * presenceChangedAt : 2019-07-17T06:51:05.368Z
         * present : false
         * product : gemini
         * provider : {"channel":"OVNcX4Y4QWqDWm51EKC1AA==","name":"boyuedeMacBook-Pro.local"}
         * ready : true
         * remoteConnect : false
         * remoteConnectUrl : null
         * sdk : 23
         * serial : edd06f8e
         * status : 3
         * statusChangedAt : 2019-07-17T06:47:28.639Z
         * usage : null
         * usageChangedAt : 2019-07-17T06:46:25.949Z
         * version : 6.0
         * using : false
         */

        private String abi;
        private boolean airplaneMode;
        private BrowserBean browser;
        private String channel;
        private String cpuPlatform;
        private String createdAt;
        private String manufacturer;
        private String model;
        private NetworkBean network;
        private String openGLESVersion;
        private String operator;
        private Object owner;
        private PhoneBean phone;
        private String platform;
        private String presenceChangedAt;
        private boolean present;
        private String product;
        private ProviderBean provider;
        private boolean ready;
        private boolean remoteConnect;
        private Object remoteConnectUrl;
        private String sdk;
        private String serial;
        private int status;
        private String statusChangedAt;
        private Object usage;
        private String usageChangedAt;
        private String version;
        private boolean using;

        public String getAbi() {
            return abi;
        }

        public void setAbi(String abi) {
            this.abi = abi;
        }

        public boolean isAirplaneMode() {
            return airplaneMode;
        }

        public void setAirplaneMode(boolean airplaneMode) {
            this.airplaneMode = airplaneMode;
        }

        public BrowserBean getBrowser() {
            return browser;
        }

        public void setBrowser(BrowserBean browser) {
            this.browser = browser;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getCpuPlatform() {
            return cpuPlatform;
        }

        public void setCpuPlatform(String cpuPlatform) {
            this.cpuPlatform = cpuPlatform;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public NetworkBean getNetwork() {
            return network;
        }

        public void setNetwork(NetworkBean network) {
            this.network = network;
        }

        public String getOpenGLESVersion() {
            return openGLESVersion;
        }

        public void setOpenGLESVersion(String openGLESVersion) {
            this.openGLESVersion = openGLESVersion;
        }

        public String getOperator() {
            return operator;
        }

        public void setOperator(String operator) {
            this.operator = operator;
        }

        public Object getOwner() {
            return owner;
        }

        public void setOwner(Object owner) {
            this.owner = owner;
        }

        public PhoneBean getPhone() {
            return phone;
        }

        public void setPhone(PhoneBean phone) {
            this.phone = phone;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getPresenceChangedAt() {
            return presenceChangedAt;
        }

        public void setPresenceChangedAt(String presenceChangedAt) {
            this.presenceChangedAt = presenceChangedAt;
        }

        public boolean isPresent() {
            return present;
        }

        public void setPresent(boolean present) {
            this.present = present;
        }

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public ProviderBean getProvider() {
            return provider;
        }

        public void setProvider(ProviderBean provider) {
            this.provider = provider;
        }

        public boolean isReady() {
            return ready;
        }

        public void setReady(boolean ready) {
            this.ready = ready;
        }

        public boolean isRemoteConnect() {
            return remoteConnect;
        }

        public void setRemoteConnect(boolean remoteConnect) {
            this.remoteConnect = remoteConnect;
        }

        public Object getRemoteConnectUrl() {
            return remoteConnectUrl;
        }

        public void setRemoteConnectUrl(Object remoteConnectUrl) {
            this.remoteConnectUrl = remoteConnectUrl;
        }

        public String getSdk() {
            return sdk;
        }

        public void setSdk(String sdk) {
            this.sdk = sdk;
        }

        public String getSerial() {
            return serial;
        }

        public void setSerial(String serial) {
            this.serial = serial;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getStatusChangedAt() {
            return statusChangedAt;
        }

        public void setStatusChangedAt(String statusChangedAt) {
            this.statusChangedAt = statusChangedAt;
        }

        public Object getUsage() {
            return usage;
        }

        public void setUsage(Object usage) {
            this.usage = usage;
        }

        public String getUsageChangedAt() {
            return usageChangedAt;
        }

        public void setUsageChangedAt(String usageChangedAt) {
            this.usageChangedAt = usageChangedAt;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public boolean isUsing() {
            return using;
        }

        public void setUsing(boolean using) {
            this.using = using;
        }

        public static class BrowserBean {
            /**
             * apps : [{"id":"com.android.browser/.BrowserActivity","name":"Browser","selected":false,"system":true,"type":"android-browser","developer":"Google Inc."}]
             * selected : false
             */

            private boolean selected;
            private List<AppsBean> apps;

            public boolean isSelected() {
                return selected;
            }

            public void setSelected(boolean selected) {
                this.selected = selected;
            }

            public List<AppsBean> getApps() {
                return apps;
            }

            public void setApps(List<AppsBean> apps) {
                this.apps = apps;
            }

            public static class AppsBean {
                /**
                 * id : com.android.browser/.BrowserActivity
                 * name : Browser
                 * selected : false
                 * system : true
                 * type : android-browser
                 * developer : Google Inc.
                 */

                private String id;
                private String name;
                private boolean selected;
                private boolean system;
                private String type;
                private String developer;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public boolean isSelected() {
                    return selected;
                }

                public void setSelected(boolean selected) {
                    this.selected = selected;
                }

                public boolean isSystem() {
                    return system;
                }

                public void setSystem(boolean system) {
                    this.system = system;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getDeveloper() {
                    return developer;
                }

                public void setDeveloper(String developer) {
                    this.developer = developer;
                }
            }
        }

        public static class NetworkBean {
            /**
             * connected : true
             * failover : false
             * roaming : false
             * subtype :
             * type : WIFI
             */

            private boolean connected;
            private boolean failover;
            private boolean roaming;
            private String subtype;
            private String type;

            public boolean isConnected() {
                return connected;
            }

            public void setConnected(boolean connected) {
                this.connected = connected;
            }

            public boolean isFailover() {
                return failover;
            }

            public void setFailover(boolean failover) {
                this.failover = failover;
            }

            public boolean isRoaming() {
                return roaming;
            }

            public void setRoaming(boolean roaming) {
                this.roaming = roaming;
            }

            public String getSubtype() {
                return subtype;
            }

            public void setSubtype(String subtype) {
                this.subtype = subtype;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class PhoneBean {
            /**
             * iccid : null
             * imei : 862033032250027
             * imsi : null
             * network : UNKNOWN
             * phoneNumber : null
             */

            private Object iccid;
            private String imei;
            private Object imsi;
            private String network;
            private Object phoneNumber;

            public Object getIccid() {
                return iccid;
            }

            public void setIccid(Object iccid) {
                this.iccid = iccid;
            }

            public String getImei() {
                return imei;
            }

            public void setImei(String imei) {
                this.imei = imei;
            }

            public Object getImsi() {
                return imsi;
            }

            public void setImsi(Object imsi) {
                this.imsi = imsi;
            }

            public String getNetwork() {
                return network;
            }

            public void setNetwork(String network) {
                this.network = network;
            }

            public Object getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(Object phoneNumber) {
                this.phoneNumber = phoneNumber;
            }
        }

        public static class ProviderBean {
            /**
             * channel : OVNcX4Y4QWqDWm51EKC1AA==
             * name : boyuedeMacBook-Pro.local
             */

            private String channel;
            private String name;

            public String getChannel() {
                return channel;
            }

            public void setChannel(String channel) {
                this.channel = channel;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
