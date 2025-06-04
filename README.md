# 🔧 UI Test Automation with Jenkins + Selenium Grid (Java)

Этот проект позволяет запускать UI-тесты на Java (Selenide / Selenium) через Jenkins и Selenium Grid, развёрнутые локально с помощью Docker Compose.

---

## 📦 Состав

- `Jenkins` (8080)
- `Selenium Grid Hub` (4444)
- `Chrome Node`
- Docker-сеть для взаимодействия

---

## 🚀 Запуск окружения

> Убедись, что установлен Docker и Docker Compose.

```bash
docker-compose up -d
```

```bash
docker-compose down
```

Подожди 15–30 секунд.

Теперь доступны:
Jenkins: http://localhost:8080
Selenium Grid UI: http://localhost:4444/ui/

### 🔐 Как получить пароль для Jenkins:
```bash
docker exec -it jenkins cat /var/jenkins_home/secrets/initialAdminPassword
```

