#!/usr/bin/env groovy

def run(String credId, String zone) {
    
    withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'cloudflare-api',
                    usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD'],]) {
                        
    
    sh """#!/bin/bash
    set -x
    curl -X DELETE "https://api.cloudflare.com/client/v4/zones/${zone}/purge_cache" \
    -H "Content-Type:application/json" \
    -H "X-Auth-Key:$PASSWORD" \
    -H "X-Auth-Email:$USERNAME" \
    --data '{"purge_everything":true}'
    """
    }
}
