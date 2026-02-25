# Full-Version Pomodoro Timer (Dockerized)

This repository contains the full-stack distribution of the **Pomodoro Timer** application. Unlike the decoupled versions, this repository is designed for developers to orchestrate the entire ecosystem (Frontend, Backend, and Database) locally using **Docker**.

##  Architecture & Stack

The project is architected into three main services that communicate within a virtualized network:

* **Frontend:** A web interface built with HTML, CSS, and JS, served by an **Nginx** server.
* **Backend:** A RESTful API built with **Java 17 and Spring Boot**.
* **Database:** A **Microsoft SQL Server (2022)** instance for robust data persistence.

##  Docker Orchestration

The project utilizes a multi-stage build strategy and Docker Compose for orchestration:

* **Multi-stage Builds:** The Backend Dockerfile uses a Maven image to compile the `.jar` file and then migrates it to a slim JDK-Alpine image to minimize the final container size and improve security.
* **Process Management:** The backend uses the *Exec Form* (`ENTRYPOINT`) to ensure the JVM receives the `SIGTERM` signal directly, allowing for graceful shutdowns.
* **Persistence:** A managed **Docker Volume** (`sql_data`) is implemented to ensure that database information persists even after the containers are stopped or removed.


##  Prerequisites

Before running this project, ensure you have the following installed:
* [Docker Desktop](https://www.docker.com/products/docker-desktop/)
* Git

##  Installation & Setup

To get the full environment running locally, follow these steps:

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/Yandell-code-master/Full-Version-Pomodoro-Timer.git](https://github.com/Yandell-code-master/Full-Version-Pomodoro-Timer.git)
    cd Full-Version-Pomodoro-Timer
    ```

2.  **Build and Start the containers:**
    Run the following command in the root directory (where the `docker-compose.yaml` is located):
    ```bash
    docker-compose up --build
    ```

3.  **Access the Application:**
    Once the containers are healthy, open your browser and navigate to:
    * **Frontend:** `http://localhost:8000`

##  Environment Configuration

The `docker-compose.yaml` includes pre-configured environment variables for:
* **Spring Datasource:** Connected to the SQL Server container.
* **JWT Secret:** For secure authentication.
* **Third-party Integrations:** Configured for Google Auth, Cloudinary (Images), and Resend (Emails).

> **Note:** The database is completely local. All data generated during your session will be stored in your machine's Docker-managed volumes.

---
Developed by [Yandell-code-master](https://github.com/Yandell-code-master)