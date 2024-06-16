terraform {
  backend "gcs" {
    bucket = "gcpterraformbackend"
    prefix = "terraform/tfstate"
    
  }
}