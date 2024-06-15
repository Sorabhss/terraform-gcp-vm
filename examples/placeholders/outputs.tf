# [terraform-project]/outputs.tf

# This will return a map with all of the outputs for the module
output "test_instance" {
    value = module.test_instance
}

# If you need a specific key as an output, you can use the dot notation shown above to access the map value.
output "test_instance_external_ip" {
    value = module.test_instance.network.external_ip
}
