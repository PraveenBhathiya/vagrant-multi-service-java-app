# 🚀 Multi-Tier Java App Deployment Using VirtualBox & Vagrant

## 📄 Project Overview

This is a full-stack DevOps project involving the local deployment of a multi-tier Java application using five virtual machines. Each VM represents a unique service: MySQL, Memcached, RabbitMQ, Tomcat, and Nginx. The infrastructure is set up using VirtualBox and automated with Vagrant.

### 🔧 Key Highlights

- Fully automated VM provisioning using Vagrant
- Manual installation of required services on respective VMs
- WAR-based Java application built and deployed on Tomcat
- Load balanced access through Nginx
- End-to-end configuration and service communication

---

## 📆 Project Architecture

**Application Stack:**

- **Frontend Load Balancer:** NGINX
- **App Server:** Apache Tomcat
- **Database:** MySQL
- **Cache Layer:** Memcached
- **Message Broker:** RabbitMQ

**Communication Flow:**

1. User request hits NGINX
2. Routed to Tomcat
3. Tomcat checks Memcached, queries MySQL if necessary
4. RabbitMQ handles async tasks

---

## 🔹 Tools Used

- **Virtualization:** VirtualBox
- **Provisioning:** Vagrant
- **Web Server:** NGINX
- **App Server:** Apache Tomcat
- **Database:** MySQL (MariaDB)
- **Caching:** Memcached
- **Message Queue:** RabbitMQ
- **Build Tool:** Maven

---

## 📂 Virtual Machine Setup

| VM Name | Hostname | IP Address    | OS     | Service   |
| ------- | -------- | ------------- | ------ | --------- |
| VM1     | web01    | 192.168.56.11 | Ubuntu | NGINX     |
| VM2     | app01    | 192.168.56.12 | CentOS | Tomcat    |
| VM3     | rmq01    | 192.168.56.13 | CentOS | RabbitMQ  |
| VM4     | mc01     | 192.168.56.14 | CentOS | Memcached |
| VM5     | db01     | 192.168.56.15 | CentOS | MySQL     |

All defined in one `Vagrantfile` using hostnames and static private IPs.

---

## 📚 Step-by-Step Guide

### 1. ⚙️ Prerequisites

- Install VirtualBox
- Install Vagrant
- Install `vagrant-hostmanager` plugin

```bash
brew install virtualbox vagrant
vagrant plugin install vagrant-hostmanager
```

### 2. 🔍 Clone Repository

```bash
git clone https://github.com/Muncodex/digiprofile-project.git
cd digiprofile-project
git checkout local-vagrant
```

### 3. 🔄 Launch VMs

Navigate to the Vagrantfile location:

```bash
cd vagrant/Manual_provisioning_MacOSM1
vagrant up
```

### 4. 🛠️ Install Services in Each VM

SSH into each VM using `vagrant ssh <hostname>` and follow the installation steps:

#### a. MySQL (db01)

- Install & start MariaDB
- Import `db_backup.sql` into `accounts` database

#### b. Memcached (mc01)

- Install memcached
- Modify bind address and open ports 11211/11111

#### c. RabbitMQ (rmq01)

- Install RabbitMQ
- Add user `test` with admin privileges
- Open port 5672

#### d. Tomcat (app01)

- Install Java, Maven, Git
- Deploy Tomcat
- Create systemd service
- Build `.war` using Maven
- Deploy `digiprofile-v2.war` to `/usr/local/tomcat/webapps/ROOT.war`

#### e. NGINX (web01)

- Install NGINX
- Create site config to reverse proxy to Tomcat
- Link config & restart service

---

## 🔢 Application Build & Deploy

```bash
# SSH into app01
vagrant ssh app01

# Clone repo
cd /tmp
git clone https://github.com/Muncodex/digiprofile-project.git
cd digiprofile-project/
git checkout local-setup-mun

# Build project
export MAVEN_OPTS="-Xmx512m"
mvn clean install

# Copy WAR to Tomcat
sudo cp target/digiprofile-v2.war /usr/local/tomcat/webapps/ROOT.war
sudo chown tomcat:tomcat /usr/local/tomcat/webapps -R
```

---

## 📅 Final Access

- Access the application from the browser:
  ```
  ```

[http://192.168.56.11](http://192.168.56.11)

```
- Username: `nextgen7`
- Password: `nextgen7`

---

## 🌟 Key Takeaways
- Hands-on experience with Vagrant & VirtualBox for provisioning
- Manual provisioning of services across multiple VMs
- Service-to-service communication using IP/hostnames
- WAR deployment via Tomcat
- Load balancing using NGINX

---

## 👤 Author
**Praveen Bhathiya**  
LinkedIn: [Your LinkedIn]  
GitHub: [Your GitHub URL]

---

## 🔒 License
This project is licensed under the MIT License.

---

Feel free to raise an issue or contribute enhancements!

```
