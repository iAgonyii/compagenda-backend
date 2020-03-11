FROM airhacks/glassfish
COPY ./target/compagenda.war ${DEPLOYMENT_DIR}
