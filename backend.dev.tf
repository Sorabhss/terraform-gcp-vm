
terraform {
  backend "gcs" {
    bucket  = "gcp_terraform_backend"
    prefix  = "tfstate"
  }
}
